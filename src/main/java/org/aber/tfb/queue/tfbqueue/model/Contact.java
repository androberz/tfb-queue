package org.aber.tfb.queue.tfbqueue.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
public class Contact implements Serializable {

    private String firstName;
    private String lastName;
    private String middleName;
    private LocalDate dob;
    private List<String> products;
    private String phoneNumber;

}
