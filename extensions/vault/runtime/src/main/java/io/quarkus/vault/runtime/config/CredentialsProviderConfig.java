package io.quarkus.vault.runtime.config;

import static io.quarkus.vault.CredentialsProvider.PASSWORD_PROPERTY_NAME;

import java.util.Optional;

import io.quarkus.runtime.annotations.ConfigGroup;
import io.quarkus.runtime.annotations.ConfigItem;

@ConfigGroup
public class CredentialsProviderConfig {

    /**
     * Database credentials role, as defined by https://www.vaultproject.io/docs/secrets/databases/index.html
     * <p>
     * One of database-credentials-role or kv-path needs to be defined. not both.
     */
    @ConfigItem
    public Optional<String> databaseCredentialsRole;

    /**
     * A path in vault kv store, where we will find the kv-key.
     * <p>
     * One of database-credentials-role or kv-path needs to be defined. not both.
     * <p>
     * see https://www.vaultproject.io/docs/secrets/kv/index.html
     */
    @ConfigItem
    public Optional<String> kvPath;

    /**
     * Key name to search in vault path kv-path. The value for that key is the credential.
     * <p>
     * kv-key should not be defined if kv-path is not.
     * <p>
     * see https://www.vaultproject.io/docs/secrets/kv/index.html
     */
    @ConfigItem(defaultValue = PASSWORD_PROPERTY_NAME)
    public String kvKey;

    @Override
    public String toString() {
        return "CredentialsProviderConfig{" +
                "databaseCredentialsRole='" + databaseCredentialsRole.get() + '\'' +
                ", kvPath='" + kvPath.get() + '\'' +
                ", kvKey='" + kvKey + '\'' +
                '}';
    }
}
