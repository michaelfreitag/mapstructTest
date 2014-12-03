package mapstruct.mapper;

import org.mapstruct.TargetType;

public class StatusRepository {

    public <T> T getEntityById(Long id, @TargetType Class<T> clazz) {
        // e.g. get from database
        return null;
    }
}
