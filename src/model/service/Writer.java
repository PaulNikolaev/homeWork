package model.service;

import java.io.Serializable;

public interface Writer {
    void setFilePath(String filePath);
    void save(Serializable serializable);
    Object read();
}
