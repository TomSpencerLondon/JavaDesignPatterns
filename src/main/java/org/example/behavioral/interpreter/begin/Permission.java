package org.example.behavioral.interpreter.begin;

//Terminal expression
public class Permission implements PermissionExpression {

    private final String permission;

    public Permission(String permission) {
        this.permission = permission;
    }

    @Override
    public boolean interpret(User user) {
        return user.getPermissions().contains(permission);
    }

    @Override
    public String toString() {
        return permission;
    }


}
