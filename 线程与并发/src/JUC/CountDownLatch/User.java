/**
 * FileName: User
 * Author:   yangqinkuan
 * Date:     2019-12-24 11:31
 * Description:
 */

package JUC.CountDownLatch;

public class User {
    private String name;
    private String id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        return id != null ? id.equals(user.id) : user.id == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }
}
