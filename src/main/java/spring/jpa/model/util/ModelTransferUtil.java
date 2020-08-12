package spring.jpa.model.util;

import org.modelmapper.ModelMapper;

public final class ModelTransferUtil {

    private static final ModelMapper modelMapper = new ModelMapper();

    private ModelTransferUtil() {}

    public static <T> T transfer(Object source, Class<T> targetClazz) {
        return modelMapper.map(source, targetClazz);
    }

}
