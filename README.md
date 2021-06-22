# instaparse-cli

Every commit has GraalVM-compiled native binaries artifacts.
Download them from GitHub, and drop them in your path.

```
$ instaparse-cli abs.ebnf abs
```

## Hacking

```
$ export JAVA_HOME=~/opt/graalvm-ce-java11-21.1.0
$ export PATH=$JAVA_HOME/bin:$PATH
```

```
$ gu install native-image
```

```
$ lein run abs.ebnf abs
```

```
$ lein do clean, uberjar, native  # use native-win on Windows
$ ./target/instaparse-cli abs.ebnf abs
```

```
$ lein cljfmt fix
```
