package io.netty.example.my.test;

import io.netty.util.Recycler;

public class RecyclerTest {

    public static void main(String[] args) {
        User user1 = UserCache.userRecycler.get();
        user1.setName("hello");
        user1.recycle();
        User user2 = UserCache.userRecycler.get();
        System.out.println(user2.getName());
        System.out.println(user1==user2);

    }

    static class UserCache{
        private static final Recycler<User> userRecycler = new Recycler<User>() {
            @Override
            protected User newObject(Handle<User> handle) {
                return new User(handle);
            }
        };


    }

    static final class User {
        private String name;
        private Recycler.Handle<User> handle;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public User(Recycler.Handle<User> handle) {
            this.handle = handle;
        }

        public void recycle(){
            handle.recycle(this);
        }
    }
}

