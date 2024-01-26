package org.socialmeli.be_java_hisp_w24_g04.integration;

import lombok.Getter;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@Getter
public class TestingSetup {
    // Setup: Possible Result Handlers
    // ---------------- Matchers ----------------
    static final ResultMatcher OK = MockMvcResultMatchers.status().isOk();
    static final ResultMatcher BAD_REQUEST = MockMvcResultMatchers.status().isBadRequest();
    static final ResultMatcher NOT_FOUND = MockMvcResultMatchers.status().isNotFound();
    // ---------------- Media Types ----------------
    static final MediaType APPLICATION_JSON = MediaType.APPLICATION_JSON;
    static final ResultMatcher CONTENT_APP_JSON = MockMvcResultMatchers
            .content()
            .contentTypeCompatibleWith(APPLICATION_JSON);
}
