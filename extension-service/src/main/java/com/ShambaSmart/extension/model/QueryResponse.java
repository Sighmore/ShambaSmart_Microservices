package com.ShambaSmart.extension.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "query_responses")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QueryResponse {

    private String queryId;
    private String status; // e.g. RECEIVED, IN_PROGRESS, RESOLVED
    private String responseMessage;



}
