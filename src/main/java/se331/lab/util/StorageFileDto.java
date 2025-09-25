package se331.lab.util;

import lombok. Builder;
import lombok. Data;

import java.util.List;

@Builder
@Data
public class StorageFileDto {
    String name;
    List<String> images;
}
