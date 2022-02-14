# instaparse-cli

Parses files using EBNF grammars, and outputs an AST in JSON format, including column/line annotations.

Every commit has GraalVM-compiled native binaries artifacts.
Download them from GitHub, and drop them in your path.

```
$ instaparse-cli abs.ebnf abs
```

See https://github.com/Engelberg/instaparse for the EBNF specification-

## Hacking

```
$ export JAVA_HOME=~/opt/graalvm-ce-java17-22.0.0.2/
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
