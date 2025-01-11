package com.rlabs.AuthenticationWithJWTApp.bl;

import com.rlabs.AuthenticationWithJWTApp.entities.Data;
import com.rlabs.AuthenticationWithJWTApp.entities.User;
import com.rlabs.AuthenticationWithJWTApp.repositories.DataRepository;
import com.rlabs.AuthenticationWithJWTApp.repositories.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DataBL {

    @Autowired
    DataRepository dataRepository;

    @PostConstruct
    public void createDummyData()
    {
        List<Data> dummyData = new ArrayList<>();
        dummyData.add(Data.builder()
                .title("Lorem Ipsum 1")
                .description("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse non justo ac turpis gravida dignissim.")
                .build());
        dummyData.add(Data.builder()
                .title("Lorem Ipsum 2")
                .description("Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam.")
                .build());
        dummyData.add(Data.builder()
                .title("Lorem Ipsum 3")
                .description("Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.")
                .build());
        dummyData.add(Data.builder()
                .title("Lorem Ipsum 4")
                .description("Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.")
                .build());
        dummyData.add(Data.builder()
                .title("Lorem Ipsum 5")
                .description("Curabitur vulputate nibh eu metus tincidunt, in ultricies nisi scelerisque. Integer in dui mattis, interdum justo at, sagittis tortor.")
                .build());
        this.dataRepository.saveAll(dummyData);
    }
    public List<Data> getAll()
    {
        return this.dataRepository.findAll();
    }
}
