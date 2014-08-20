(defproject mies-om-weasel "0.1.0-SNAPSHOT"
  :description "FIXME: write this!"
  :url "http://example.com/FIXME"

  :dependencies [;; clojure
                 [org.clojure/clojure "1.6.0"]
                 [org.clojure/clojurescript "0.0-2311"]
                 [org.clojure/core.async "0.1.267.0-0d7780-alpha"]
                 [org.clojure/core.match "0.2.2"]

                 ;; om
                 [om "0.7.1"]
                 [sablono "0.2.21"]
                 [crate "0.2.5"]
                 [prismatic/om-tools "0.3.2"]
                 [secretary "1.2.0"]
                 [pleasetrythisathome/tao "0.1.5"]


                 ;; dev tools
                 [omdev "0.1.3-SNAPSHOT"]
                 [shodan "0.3.0"]
                 [ankha "0.1.4"]
                 [figwheel "0.1.4-SNAPSHOT"]]

  :plugins [[lein-cljsbuild "1.0.3"]
            [com.cemerick/clojurescript.test "0.3.1"]
            [lein-figwheel "0.1.4-SNAPSHOT"]]
  :hooks [leiningen.cljsbuild]
  :source-paths ["src"]

  :figwheel {:http-server-root "public"
             :server-port 3449
             :css-dirs ["public/resources/css"]})
