package org.socialmeli.be_java_hisp_w24_g04.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.collection.IsCollectionWithSize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {
    MockMvc mockMvc;
    ObjectMapper mapper;

    @Autowired
    public UserControllerTest(MockMvc mockMvc, ObjectMapper mapper) {
        this.mockMvc = mockMvc;
        this.mapper = mapper;
    }

    // ---------------- ID's (valid & invalid) ----------------
    Integer userId = 101;
    Integer wrongUserId = 1;
    Integer userIdToFollow = 103;
    Integer wrongUserIdToFollow = 3;
    // ---------------- URNs ------------------
    String followedListById = "/users/{userId}/followed/list";
    String followersListById = "/users/{userId}/followers/list";
    String followersCountById = "/users/{userId}/followers/count";
    String id1FollowsId2 = "/users/{userId}/follow/{userIdToFollow}";
    String id1UnfollowsId2 = "/users/{userId}/unfollow/{userIdToUnfollow}";

    @Test
    @DisplayName("If valid userId, retrieves followed users.")
    void testIfValidUserIdRetrievesFollowedUsers() throws Exception {
        int expectedFollowedSize = 2;

        mockMvc
             .perform(
                        MockMvcRequestBuilders
                             .get(followedListById, userId)
                             .contentType(TestingSetup.APPLICATION_JSON)
             )
             .andDo(MockMvcResultHandlers.print())
             .andExpect(TestingSetup.OK)
             .andExpect(TestingSetup.CONTENT_APP_JSON)
             .andExpect(
                        MockMvcResultMatchers
                            .jsonPath(
                                    "$.data.followed",
                                    IsCollectionWithSize.hasSize(expectedFollowedSize)
                            )
                );
    }

    @Test
    @DisplayName("If invalid userId, doesn't retrieves followed users.")
    void testIfInvalidUserIdNotRetrievesFollowedUsers() throws Exception {
        String expectedErrorMessage = "User with id 1 not found";

        mockMvc
            .perform(
                        MockMvcRequestBuilders
                            .get(followedListById, wrongUserId)
                            .contentType(TestingSetup.APPLICATION_JSON)
                )
            .andDo(MockMvcResultHandlers.print())
            .andExpect(TestingSetup.NOT_FOUND)
            .andExpect(TestingSetup.CONTENT_APP_JSON)
            .andExpect(
                        MockMvcResultMatchers
                           .jsonPath("$.error")
                           .value(expectedErrorMessage)
                );
    }

    @Test
    @DisplayName("If valid userId, retrieves followers.")
    void testIfValidUserIdRetrievesFollowers() throws Exception {
        int expectedFollowedSize = 0;

        mockMvc
                .perform(
                        MockMvcRequestBuilders
                                .get(followersListById, userId)
                                .contentType(TestingSetup.APPLICATION_JSON)
                )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(TestingSetup.OK)
                .andExpect(TestingSetup.CONTENT_APP_JSON)
                .andExpect(
                        MockMvcResultMatchers
                                .jsonPath(
                                        "$.data.followers",
                                        IsCollectionWithSize.hasSize(expectedFollowedSize)
                                )
                );
    }

    @Test
    @DisplayName("If invalid userId, doesn't retrieves followers.")
    void testIfInvalidUserIdNotRetrievesFollowers() throws Exception {
        String expectedErrorMessage = "User with id 1 not found";

        mockMvc
                .perform(
                        MockMvcRequestBuilders
                                .get(followersListById, wrongUserId)
                                .contentType(TestingSetup.APPLICATION_JSON)
                )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(TestingSetup.NOT_FOUND)
                .andExpect(TestingSetup.CONTENT_APP_JSON)
                .andExpect(
                        MockMvcResultMatchers
                                .jsonPath("$.error")
                                .value(expectedErrorMessage)
                );
    }

    @Test
    @DisplayName("If valid userId, retrieves followers count.")
    void testIfValidUserIdRetrievesFollowersCount() throws Exception {
        int expectedFollowersCount = 0;

        mockMvc
              .perform(
                        MockMvcRequestBuilders
                              .get(followersCountById, userId)
                              .contentType(TestingSetup.APPLICATION_JSON)
                )
              .andDo(MockMvcResultHandlers.print())
              .andExpect(TestingSetup.OK)
              .andExpect(TestingSetup.CONTENT_APP_JSON)
              .andExpect(
                        MockMvcResultMatchers
                              .jsonPath("$.data.followers_count")
                                .value(expectedFollowersCount)
                );
    }

    @Test
    @DisplayName("If invalid userId, doesn't retrieves followers count.")
    void testIfInvalidUserIdNotRetrievesFollowersCount() throws Exception {
        String expectedErrorMessage = "User with id 1 not found";

        mockMvc
                .perform(
                        MockMvcRequestBuilders
                                .get(followersCountById, wrongUserId)
                                .contentType(TestingSetup.APPLICATION_JSON)
                )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(TestingSetup.NOT_FOUND)
                .andExpect(TestingSetup.CONTENT_APP_JSON)
                .andExpect(
                        MockMvcResultMatchers
                                .jsonPath("$.error")
                                .value(expectedErrorMessage)
                );
    }

    @Test
    @DisplayName("If userId and userIdToFollow are right, it follows.")
    void testIfUserIdUserIdToFollowValidFollows() throws Exception {
        mockMvc
              .perform(
                        MockMvcRequestBuilders
                              .post(id1FollowsId2, userId, userIdToFollow)
                              .contentType(TestingSetup.APPLICATION_JSON)
                )
              .andDo(MockMvcResultHandlers.print())
              .andExpect(TestingSetup.OK);
    }

    @Test
    @DisplayName("If userId is right, but userIdToFollow is wrong, it doesn't follow.")
    void testIfUserIdRightUserIdToFollowWrong() throws Exception {
        mockMvc
            .perform(
                        MockMvcRequestBuilders
                            .post(id1FollowsId2, userId, wrongUserIdToFollow)
                            .contentType(TestingSetup.APPLICATION_JSON)
                )
            .andDo(MockMvcResultHandlers.print())
            .andExpect(TestingSetup.NOT_FOUND);
    }

    @Test
    @DisplayName("If userId is wrong, but userIdToFollow is right, it doesn't follow.")
    void testIfUserIdWrongUserIdToFollowRight() throws Exception {
        mockMvc
                .perform(
                        MockMvcRequestBuilders
                                .post(id1FollowsId2, userId, wrongUserIdToFollow)
                                .contentType(TestingSetup.APPLICATION_JSON)
                )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(TestingSetup.NOT_FOUND);
    }

    @Test
    @DisplayName("If userId and userIdToUnfollow are right, it unfollows.")
    void testIfUserIdUserIdToUnfollowValidUnfollows() throws Exception {
        mockMvc
            .perform(
                        MockMvcRequestBuilders
                            .post(id1UnfollowsId2, userId, userIdToFollow)
                            .contentType(TestingSetup.APPLICATION_JSON)
                )
            .andDo(MockMvcResultHandlers.print())
            .andExpect(TestingSetup.OK);
    }

    @Test
    @DisplayName("If userId is right, but userIdToUnfollow is wrong, it doesn't unfollow.")
    void testIfUserIdRightUserIdToUnfollowWrong() throws Exception {
        mockMvc
          .perform(
                        MockMvcRequestBuilders
                          .post(id1UnfollowsId2, userId, wrongUserIdToFollow)
                          .contentType(TestingSetup.APPLICATION_JSON)
                )
          .andDo(MockMvcResultHandlers.print())
          .andExpect(TestingSetup.NOT_FOUND);
    }

    @Test
    @DisplayName("If userId is wrong, but userIdToUnfollow is right, it doesn't unfollow.")
    void testIfUserIdWrongUserIdToUnfollowRight() throws Exception {
        mockMvc
               .perform(
                        MockMvcRequestBuilders
                               .post(id1UnfollowsId2, userId, wrongUserIdToFollow)
                               .contentType(TestingSetup.APPLICATION_JSON)
                )
               .andDo(MockMvcResultHandlers.print())
               .andExpect(TestingSetup.NOT_FOUND);
    }
}
