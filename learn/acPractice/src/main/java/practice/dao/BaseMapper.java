package practice.dao;

import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface BaseMapper {
    Object getEntity(Map<String, Object> param);
}
