package darius.licenta.backend.dto.elasticsearch.search;

import java.util.List;
import java.util.Objects;

public class CollectionNamesForFieldReturn {
    List<String> collectionNames;

    public CollectionNamesForFieldReturn() {

    }

    public CollectionNamesForFieldReturn(List<String> collectionNames) {
        this.collectionNames = collectionNames;
    }

    public void setCollectionNames(List<String> collectionNames) {
        this.collectionNames = collectionNames;
    }

    public List<String> getCollectionNames() {
        return collectionNames;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CollectionNamesForFieldReturn that = (CollectionNamesForFieldReturn) o;

        return Objects.equals(collectionNames, that.collectionNames);
    }

    @Override
    public int hashCode() {
        return collectionNames != null ? collectionNames.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "CollectionNamesForFieldReturn{" +
                "collectionNames=" + collectionNames +
                '}';
    }
}
