package org.aber.tfb.queue.tfbqueue.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Getter
@NoArgsConstructor
public class Contact implements Serializable {

    private String firstName;
    private String lastName;
    private String middleName;
    private LocalDate dob;
    private List<String> products;
    private String phoneNumber;

}
