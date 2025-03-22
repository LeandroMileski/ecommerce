package dev.leandro.ecommerce.service;

import org.springframework.stereotype.Service;
import dev.leandro.ecommerce.controller.dto.CreateUserDto;
import dev.leandro.ecommerce.entities.BillingAddressEntity;
import dev.leandro.ecommerce.entities.UserEntity;
import dev.leandro.ecommerce.repository.BillingAddressRepository;
import dev.leandro.ecommerce.repository.UserRepository;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BillingAddressRepository billingAddressRepository;

    public UserService(UserRepository userRepository,
                       BillingAddressRepository billingAddressRepository) {
        this.userRepository = userRepository;
        this.billingAddressRepository = billingAddressRepository;
    }

    public UserEntity createUser(CreateUserDto dto) {

        var billingAddress =  new BillingAddressEntity();
        billingAddress.setAddress(dto.address());
        billingAddress.setNumber(dto.number());
        billingAddress.setComplement(dto.complement());

        var user = new UserEntity();
        user.setFullName(dto.fullName());
        user.setBillingAddress(billingAddress);

        return userRepository.save(user);
    }

    public Optional<UserEntity> findById(UUID userId) {
        return userRepository.findById(userId);
    }

    public boolean deleteById(UUID userId) {

        var user = userRepository.findById(userId);

        if (user.isPresent()) {

            userRepository.deleteById(userId);
        }

        return user.isPresent();
    }
}
