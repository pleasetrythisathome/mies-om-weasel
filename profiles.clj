{:dev {:dependencies [[com.cemerick/piggieback "0.1.3"]
                      [weasel "0.3.0"]]

       :cljsbuild
       {:builds [{:id "test"
                  :source-paths ["src" "test"]
                  :compiler {:output-dir "resources/public/out/test"
                             :output-to "resources/public/test.js"
                             :source-map "resources/public/test.js.map"
                             :optimizations :none}}
                 {:id "dev"
                  :source-paths ["src"]
                  :compiler {:output-dir "resources/public/out/dev"
                             :output-to "resources/public/dev.js"
                             :source-map "resources/public/dev.js.map"
                             :optimizations :none}}
                 {:id "prod"
                  :source-paths ["src"]
                  :compiler {:output-dir "resources/public/out/dev"
                             :output-to "resources/public/prod.js"
                             :optimizations :advanced
                             :pretty-print false
                             :preamble ["react/react.min.js"]
                             :externs ["react/externs/react.js"]}}]}

       :repl-options {:nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]}

       :injections [(require  '[weasel.repl.websocket :as weasel]
                              '[cemerick.piggieback :as piggieback]
                              '[clojure.pprint :refer [pprint]])
                    (defn browser-repl-env []
                      (weasel/repl-env :ip "0.0.0.0" :port 9001))
                    (defn browser-repl []
                      (piggieback/cljs-repl :repl-env (browser-repl-env)))]}}
