package org.aber.tfb.queue.tfbqueue.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "TASKS")
@Data
public class WorkItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TASK_ID")
    private Long id;

    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;
    @Column(name = "LAST_NAME", nullable = false)
    private String lasName;
    @Column(name = "MIDDLE_NAME")
    private String middleName;

    @Column(name = "PHONE")
    private String phoneNumber;

    @Column(name = "REGION")
    private String region;

}
