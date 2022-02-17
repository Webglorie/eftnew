package com.efteling.eft.Ticket;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface TickRepository extends CrudRepository<Ticket, Long> {
}
