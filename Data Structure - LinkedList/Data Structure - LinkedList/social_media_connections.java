package Submission_of_Data_Structure_LinkedList;

public class social_media_connections {

    static class FriendNode {
        int friendId;
        FriendNode next;
        FriendNode(int friendId) { this.friendId = friendId; }
    }

    static class UserNode {
        int uid;
        String name;
        int age;
        FriendNode friendsHead;
        UserNode next;

        UserNode(int uid, String name, int age) {
            this.uid = uid;
            this.name = name;
            this.age = age;
        }
    }

    UserNode head = null;

    public void addUser(int uid, String name, int age) {
        UserNode u = new UserNode(uid, name, age);
        u.next = head;
        head = u;
    }

    public UserNode findUser(int uid) {
        UserNode temp = head;
        while (temp != null) {
            if (temp.uid == uid) return temp;
            temp = temp.next;
        }
        return null;
    }

    public void addFriend(int uid1, int uid2) {
        UserNode u1 = findUser(uid1);
        UserNode u2 = findUser(uid2);
        if (u1 != null && u2 != null) {
            FriendNode f1 = new FriendNode(uid2);
            f1.next = u1.friendsHead;
            u1.friendsHead = f1;

            FriendNode f2 = new FriendNode(uid1);
            f2.next = u2.friendsHead;
            u2.friendsHead = f2;
        }
    }

    public void displayFriends(int uid) {
        UserNode u = findUser(uid);
        if (u != null) {
            FriendNode temp = u.friendsHead;
            System.out.print(u.name + "'s friends: ");
            while (temp != null) {
                System.out.print(temp.friendId + " ");
                temp = temp.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        social_media_connections smc = new social_media_connections();
        smc.addUser(1, "Alice", 25);
        smc.addUser(2, "Bob", 26);
        smc.addUser(3, "Charlie", 24);
        smc.addFriend(1, 2);
        smc.addFriend(1, 3);
        smc.displayFriends(1);
    }
}