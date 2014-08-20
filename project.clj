(defproject mies-om-weasel "0.1.0-SNAPSHOT"
  :description "FIXME: write this!"
  :url "http://example.com/FIXME"

  :dependencies [;; clojure
                 [org.clojure/clojure "1.6.0"]
                 [org.clojure/clojurescript "0.0-2268"]
                 [org.clojure/core.async "0.1.267.0-0d7780-alpha"]
                 [org.clojure/core.match "0.2.1"]

                 ;; om
                 [om "0.7.0"]
                 [sablono "0.2.20"]
                 [prismatic/om-tools "0.2.2"]
                 [secretary "1.2.0"]
                 [pleasetrythisathome/tao "0.1.5"]


                 ;; dev tools
                 [omdev "0.1.3-SNAPSHOT"]
                 [shodan "0.3.0"]
                 [ankha "0.1.3"]]

  :plugins [[lein-cljsbuild "1.0.3"]]
  :hooks [leiningen.cljsbuild]
  :source-paths ["src"])
