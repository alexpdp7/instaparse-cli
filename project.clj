(defproject instaparse-cli "master"
  :dependencies [[org.clojure/clojure "1.10.3"],
                 [instaparse "1.4.10"],
                 [org.clojure/data.json "2.4.0"]]
  :plugins [[lein-cljfmt "0.8.0"]]
  :main instaparse-cli.core
  :profiles {:uberjar {:aot :all}
             :dev {:plugins [[lein-shell "0.5.0"]]}}
  :aliases {
    "native" ["shell" "native-image"
    "--report-unsupported-elements-at-runtime"
    "--initialize-at-build-time"
    "--no-server"
    "-jar" "./target/${:uberjar-name:-${:name}-${:version}-standalone.jar}"
    "-H:Name=./target/${:name}"],
    "native-win" ["shell" "native-image.cmd"
    "--report-unsupported-elements-at-runtime"
    "--initialize-at-build-time"
    "--no-server"
    "-jar" "./target/${:uberjar-name:-${:name}-${:version}-standalone.jar}"
    "-H:Name=./target/${:name}"],
    })
