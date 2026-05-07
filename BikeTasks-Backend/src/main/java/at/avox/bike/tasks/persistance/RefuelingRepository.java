package at.avox.bike.tasks.persistance;

import at.avox.bike.tasks.persistance.entity.RefuelingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.UUID;

@Repository
public interface RefuelingRepository extends JpaRepository<RefuelingEntity, UUID> {
    Set<RefuelingEntity> findAllByBikeId(UUID bikeId);
}
