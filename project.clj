(defproject advent-of-code-2018 "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]]
  :plugins [[lein-cljfmt "0.6.2"]
            [lein-bikeshed "0.5.1"]
            [lein-kibit "0.1.6"]]
  :main ^:skip-aot advent-of-code-2018.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
