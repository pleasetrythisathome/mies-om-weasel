{:dev {:dependencies [[com.cemerick/piggieback "0.1.3"]
                      [weasel "0.3.0"]]

       :cljsbuild
       {:builds [{:id "test"
                  :source-paths ["src" "test"]
                  :compiler {:output-dir "resources/public/out/test"
                             :output-to "resources/public/js/test.js"
                             :source-map true
                             :pretty-print true
                             :optimizations :none}}
                 {:id "dev"
                  :source-paths ["src"]
                  :compiler {:output-dir "resources/public/out/dev"
                             :output-to "resources/public/js/dev.js"
                             :source-map true
                             :pretty-print true
                             :optimizations :none}}
                 {:id "prod"
                  :source-paths ["src"]
                  :compiler {:output-dir "resources/public/out/prod"
                             :output-to "resources/public/js/prod.js"
                             :optimizations :advanced
                             :pretty-print false
                             :preamble ["react/react.min.js"]
                             :externs ["react/externs/react.js"]}}]}

       :aliases {"auto-test" ["do" "clean,"
                              "cljsbuild" "once" "test,"
                              "cljsbuild" "auto" "test"]
                 "auto-dev" ["do" "clean,"
                             "cljsbuild" "once" "dev,"
                             "cljsbuild" "auto" "dev"]}

       :repl-options {:nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]}

       :injections [(require  '[weasel.repl.websocket :as weasel]
                              '[cemerick.piggieback :as piggieback]
                              '[clojure.pprint :refer [pprint]])
                    (defn browser-repl-env []
                      (weasel/repl-env :ip "0.0.0.0" :port 9001))
                    (defn browser-repl []
                      (piggieback/cljs-repl :repl-env (browser-repl-env)))]}}
