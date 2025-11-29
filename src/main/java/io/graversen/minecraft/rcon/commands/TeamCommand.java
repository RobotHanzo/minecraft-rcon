package io.graversen.minecraft.rcon.commands;

import io.graversen.minecraft.rcon.commands.base.ICommand;
import io.graversen.minecraft.rcon.util.Color;

import java.util.Objects;

public class TeamCommand implements ICommand {
    public enum Visibility {
        ALWAYS("always"),
        NEVER("never"),
        HIDE_FOR_OTHER_TEAMS("hideForOtherTeams"),
        HIDE_FOR_OWN_TEAM("hideForOwnTeam");

        private final String name;

        Visibility(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public enum CollisionRule {
        ALWAYS("always"),
        NEVER("never"),
        PUSH_OTHER_TEAMS("pushOtherTeams"),
        PUSH_OWN_TEAM("pushOwnTeam");

        private final String name;

        CollisionRule(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    private final String command;

    private TeamCommand(String command) {
        this.command = command.trim();
    }

    public static TeamCommand list(String teamName) {
        return new TeamCommand("list " + Objects.requireNonNull(teamName));
    }

    public static TeamCommand add(String teamName, String displayName) {
        return new TeamCommand("add " + Objects.requireNonNull(teamName) + " " + Objects.requireNonNull(displayName));
    }

    public static TeamCommand remove(String teamName) {
        return new TeamCommand("remove " + Objects.requireNonNull(teamName));
    }

    public static TeamCommand empty(String teamName) {
        return new TeamCommand("empty " + Objects.requireNonNull(teamName));
    }

    public static TeamCommand join(String teamName, String... members) {
        return new TeamCommand("join " + Objects.requireNonNull(teamName) + " " + String.join(" ", members));
    }

    public static TeamCommand leave(String... playerNames) {
        return new TeamCommand("leave " + String.join(" ", playerNames));
    }

    public static TeamCommand modifyDisplayName(String teamName, String displayName) {
        return new TeamCommand("modify " + Objects.requireNonNull(teamName) + " displayName " + Objects.requireNonNull(displayName));
    }

    public static TeamCommand modifyColor(String teamName, Color color) {
        return new TeamCommand("modify " + Objects.requireNonNull(teamName) + " color " + Objects.requireNonNull(color));
    }

    public static TeamCommand modifyFriendlyFire(String teamName, boolean friendlyFire) {
        return new TeamCommand("modify " + Objects.requireNonNull(teamName) + " friendlyFire " + friendlyFire);
    }

    public static TeamCommand modifySeeFriendlyInvisibles(String teamName, boolean seeFriendlyInvisibles) {
        return new TeamCommand("modify " + Objects.requireNonNull(teamName) + " seeFriendlyInvisibles " + seeFriendlyInvisibles);
    }

    public static TeamCommand modifyNametagVisibility(String teamName, Visibility nametagVisibility) {
        return new TeamCommand("modify " + Objects.requireNonNull(teamName) + " nametagVisibility " + Objects.requireNonNullElse(nametagVisibility, Visibility.ALWAYS));
    }

    public static TeamCommand modifyDeathMessageVisibility(String teamName, Visibility deathMessageVisibility) {
        return new TeamCommand("modify " + Objects.requireNonNull(teamName) + " deathMessageVisibility " + Objects.requireNonNullElse(deathMessageVisibility, Visibility.ALWAYS));
    }

    public static TeamCommand modifyCollisionRule(String teamName, CollisionRule collisionRule) {
        return new TeamCommand("modify " + Objects.requireNonNull(teamName) + " collisionRule " + Objects.requireNonNullElse(collisionRule, CollisionRule.ALWAYS));
    }

    public static TeamCommand modifyPrefix(String teamName, String prefix) {
        return new TeamCommand("modify " + Objects.requireNonNull(teamName) + " prefix " + Objects.requireNonNull(prefix));
    }

    public static TeamCommand modifySuffix(String teamName, String suffix) {
        return new TeamCommand("modify " + Objects.requireNonNull(teamName) + " suffix " + Objects.requireNonNull(suffix));
    }

    @Override
    public String command() {
        return "team " + command;
    }
}
