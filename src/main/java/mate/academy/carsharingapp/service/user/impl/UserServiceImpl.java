package mate.academy.carsharingapp.service.user.impl;

import java.util.Set;
import lombok.RequiredArgsConstructor;
import mate.academy.carsharingapp.dto.user.UserRegistrationRequestDto;
import mate.academy.carsharingapp.dto.user.UserResponseDto;
import mate.academy.carsharingapp.dto.user.UserRoleUpdateDto;
import mate.academy.carsharingapp.exception.EntityNotFoundException;
import mate.academy.carsharingapp.exception.RegistrationException;
import mate.academy.carsharingapp.mapper.UserMapper;
import mate.academy.carsharingapp.model.Role;
import mate.academy.carsharingapp.model.User;
import mate.academy.carsharingapp.repository.RoleRepository;
import mate.academy.carsharingapp.repository.UserRepository;
import mate.academy.carsharingapp.service.user.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private static final Role.RoleName DEFAULT_ROLE_NAME = Role.RoleName.CUSTOMER;
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public void updateUserRole(Long id, UserRoleUpdateDto userRoleUpdateDto) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("User with id " + id + " not found"));
        Role role = roleRepository.findRoleByName(userRoleUpdateDto.name()).orElseThrow(
                () -> new EntityNotFoundException("Role with name "
                        + userRoleUpdateDto.name() + " not found"));
        user.getRoles().add(role);
        userMapper.toDto(userRepository.save(user));
    }

    @Override
    public UserResponseDto getUserInfo(Long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("User with id " + id + " not found"));
        return userMapper.toDto(user);
    }

    @Transactional
    @Override
    public UserResponseDto updateUserInfo(Long id, UserRegistrationRequestDto userRegistrationRequestDto) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("User with id " + id + " not found"));
        User updatedUser = userMapper.updateUser(userRegistrationRequestDto, user);
        updatedUser.setPassword(user.getPassword());
        updatedUser.setRoles(user.getRoles());
        return userMapper.toDto(userRepository.save(updatedUser));
    }

    @Transactional
    @Override
    public UserResponseDto register(UserRegistrationRequestDto userRegistrationRequestDto)
            throws RegistrationException {
        if (userRepository.findByEmail(userRegistrationRequestDto.email()).isPresent()) {
            throw new RegistrationException("Email address already in use");
        }
        User user = userMapper.toModel(userRegistrationRequestDto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Role defaultRole = roleRepository.findRoleByName(DEFAULT_ROLE_NAME)
                .orElseThrow(() -> new RegistrationException("Can't find default role"));
        user.setRoles(Set.of(defaultRole));
        return userMapper.toDto(userRepository.save(user));
    }

    @Override
    public User getUserFromAuthentication(Authentication authentication) {
        return (User) authentication.getPrincipal();
    }
}
