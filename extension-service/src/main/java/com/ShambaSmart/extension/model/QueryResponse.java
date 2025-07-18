package com.ShambaSmart.extension.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "query_responses")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QueryResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String queryId;
    private String status; // e.g. RECEIVED, IN_PROGRESS, RESOLVED
    private String responseMessage;



}
