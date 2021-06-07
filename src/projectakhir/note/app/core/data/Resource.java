package projectakhir.note.app.core.data;

public abstract class Resource<RequestType, ResultType> {

    public abstract ResultType loadData(RequestType data);
    public abstract RequestType call();
    public ResultType asResult() {
        return loadData(call());
    }
}