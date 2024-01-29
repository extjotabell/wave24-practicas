package org.be_java_hisp_w24_g05.service;


import org.be_java_hisp_w24_g05.repository.IUserRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {


    @Mock
    private IUserRepository userRepository;

    @InjectMocks
    private ProductService productService;
}
