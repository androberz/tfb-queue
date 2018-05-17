package org.aber.tfb.queue.tfbqueue.repository;

import org.aber.tfb.queue.tfbqueue.model.WorkItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkItemRepository extends JpaRepository<WorkItem, Long> {
}
