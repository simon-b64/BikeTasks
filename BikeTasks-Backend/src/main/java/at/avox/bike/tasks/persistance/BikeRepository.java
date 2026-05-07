package at.avox.bike.tasks.persistance;

import at.avox.bike.tasks.persistance.entity.BikeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BikeRepository extends JpaRepository<BikeEntity, UUID> {
}
