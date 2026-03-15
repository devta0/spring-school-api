package com.devta.schoolsapi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class SchoolApiApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void studentCrudFlow_shouldWork() throws Exception {
        String studentJson = """
                {
                  \"name\": \"Alice\",
                  \"age\": 16,
                  \"grade\": \"10th\"
                }
                """;

        mockMvc.perform(post("/api/students")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(studentJson))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").isNumber())
                .andExpect(jsonPath("$.name").value("Alice"));

        mockMvc.perform(get("/api/students"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Alice"));

        String updateJson = """
                {
                  \"name\": \"Alice Updated\",
                  \"age\": 17,
                  \"grade\": \"11th\"
                }
                """;

        mockMvc.perform(put("/api/students/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(updateJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Alice Updated"));

        mockMvc.perform(delete("/api/students/1"))
                .andExpect(status().isNoContent());
    }

    @Test
    void teacherCrudFlow_shouldWork() throws Exception {
        String teacherJson = """
                {
                  \"name\": \"Mr. Sharma\",
                  \"subject\": \"Mathematics\",
                  \"experienceYears\": 8
                }
                """;

        mockMvc.perform(post("/api/teachers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(teacherJson))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").isNumber())
                .andExpect(jsonPath("$.subject").value("Mathematics"));

        mockMvc.perform(get("/api/teachers"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Mr. Sharma"));

        String updateJson = """
                {
                  \"name\": \"Mrs. Sharma\",
                  \"subject\": \"Physics\",
                  \"experienceYears\": 10
                }
                """;

        mockMvc.perform(put("/api/teachers/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(updateJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.subject").value("Physics"));

        mockMvc.perform(delete("/api/teachers/1"))
                .andExpect(status().isNoContent());
    }
}
