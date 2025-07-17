package mate.academy.carsharingapp.service.user.impl;

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

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private static final Role.RoleName DEFAULT_ROLE_NAME = Role.RoleName.CUSTOMER;
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void updateUserRole(Long id, UserRoleUpdateDto userRoleUpdateDto) {

    }

    @Override
    public UserResponseDto getUserInfo(Long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("User with id " + id + " not found"));
        return userMapper.toDto(user);
    }

    @Override
    public UserResponseDto updateUserInfo(Long id, UserRegistrationRequestDto userRegistrationRequestDto) {
        return null;
    }

    @Override
    public UserResponseDto register(UserRegistrationRequestDto userRegistrationRequestDto) throws RegistrationException {
        return null;
    }

    @Override
    public User getUserFromAuthentication(Authentication authentication) {
        return null;
    }
}
