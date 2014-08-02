(ns leiningen.new.mies-om-weasel
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files]]
            [leiningen.core.main :as main]))

(def render (renderer "mies-om-weasel"))

(defn mies-om-weasel
  "minimal om template with a weasel repl"
  [name]
  (let [data {:name name
              :sanitized (name-to-path name)}]
    (main/info "Generating fresh 'lein new' mies-om-weasel project.")

    (->files data
             ["project.clj" (render "project.clj" data)]
             ["profiles.clj" (render "profiles.clj" data)]

             ["resources/public/index.html" (render "index.html" data)]
             ["src/{{sanitized}}/core.cljs" (render "core.cljs" data)]

             ["README.md" (render "README.md" data)]
             [".gitignore" (render "gitignore" data)])))
