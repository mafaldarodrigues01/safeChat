package fcul.mei.mappers;

import model.User;

public interface IMapper<T,S> {

    public T get(S s);
    public Boolean save(T t);

}
