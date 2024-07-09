package service;

import java.io.Serializable;

public interface Writer {
    void save(Serializable serializable);
    Object read();
}
