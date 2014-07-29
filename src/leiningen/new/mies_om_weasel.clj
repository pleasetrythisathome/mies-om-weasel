(ns leiningen.new.mies-om-weasel
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files]]
            [leiningen.core.main :as main]))

(def render (renderer "mies-om-weasel"))

(defn mies-om-weasel
  "FIXME: write documentation"
  [name]
  (let [data {:name name
              :sanitized (name-to-path name)}]
    (main/info "Generating fresh 'lein new' mies-om-weasel project.")
    (->files data
             ["src/{{sanitized}}/foo.clj" (render "foo.clj" data)])))
