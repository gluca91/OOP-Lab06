package it.unibo.oop.lab.collections2;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * Instructions
 * 
 * This will be an implementation of
 * {@link it.unibo.oop.lab.collections2.SocialNetworkUser}:
 * 
 * 1) complete the definition of the methods by following the suggestions
 * included in the comments below.
 * 
 * @param <U> Specific user type
 */
public class SocialNetworkUserImpl<U extends User> extends UserImpl implements SocialNetworkUser<U> {

    private static final int DEF_AGE = -1;
    private static final boolean CANNOT_ADD = false;
    private static final boolean USER_ADDED = true;

    private final Map<String, Set<U>> groupMap;

    /*
     * 
     * [FIELDS]
     * 
     * Define any necessary field
     * 
     * In order to save the people followed by a user organized in groups, adopt a
     * generic-type Map:
     * 
     * think of what type of keys and values would best suit the requirements
     */

    /*
     * [CONSTRUCTORS]
     * 
     * 1) Complete the definition of the constructor below, for building a user
     * participating in a social network, with 4 parameters, initializing:
     * 
     * - firstName - lastName - username - age and every other necessary field
     * 
     * 2) Define a further constructor where age is defaulted to -1
     */

    public SocialNetworkUserImpl(final String name, final String surname, final String user) {
        this(name, surname, user, DEF_AGE);
    }

    /**
     * Builds a new {@link SocialNetworkUserImpl}.
     * 
     * @param name    the user firstname
     * @param surname the user lastname
     * @param userAge user's age
     * @param user    alias of the user, i.e. the way a user is identified on an
     *                application
     */
    public SocialNetworkUserImpl(final String name, final String surname, final String user, final int userAge) {
        super(name, surname, user, userAge);

        this.groupMap = new HashMap<>();
    }

    /*
     * [METHODS]
     * 
     * Implements the methods below
     */

    @Override
    public boolean addFollowedUser(final String circle, final U user) {

        if (groupMap.containsKey(circle)) {
            if (groupMap.get(circle).contains(user)) {
                return CANNOT_ADD;
            }
        } else {
            groupMap.put(circle, new HashSet<U>());
        }
        groupMap.get(circle).add(user);
        return USER_ADDED;
    }

    @Override
    public Collection<U> getFollowedUsersInGroup(final String groupName) {
        if (groupMap.containsKey(groupName)) {
            return new HashSet<>(groupMap.get(groupName));
        }
        return Set.of();
    }

    @Override
    public List<U> getFollowedUsers() {

        final var tmpSet = groupMap.values().stream().reduce((i, j) -> {
            i.addAll(j);
            return i;
        }).get();

        return new LinkedList<U>(tmpSet);
    }

}
