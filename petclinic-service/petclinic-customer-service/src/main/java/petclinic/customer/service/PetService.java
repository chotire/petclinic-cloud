package petclinic.customer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import petclinic.customer.entity.Owner;
import petclinic.customer.entity.Pet;
import petclinic.customer.repository.OwnerRepository;
import petclinic.customer.repository.PetRepository;
import petclinic.customer.web.PetRequest;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PetService {
    private final OwnerRepository ownerRepository;
    private final PetRepository petRepository;

    @Transactional
    public Pet add(int ownerId, PetRequest petRequest) {
        Owner owner = ownerRepository.findById(ownerId)
                .orElseThrow(() -> new ResourceNotFoundException("Owner " + ownerId + " not found"));
        Pet pet = petRequest.toEntity();
        pet.setOwner(owner);
        return petRepository.save(pet);
    }

    @Transactional
    public void update(PetRequest petRequest) {
        Pet pet = petRepository.findById(petRequest.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Pet " + petRequest.getId() + " not found"));
        pet.update(petRequest.getName(), petRequest.getBirthDate(), petRequest.getType());
        petRepository.save(pet);
    }
}
