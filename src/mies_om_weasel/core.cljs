(ns mies-om-weasel.core
  (:require-macros [cljs.core.match.macros :refer [match]]
                   [cljs.core.async.macros :as asyncm :refer [go go-loop]])
  (:require [cljs.core.match]
            [cljs.core.async :as async :refer [<! >! put! chan close! timeout alts!]]

            [om.core :as om :include-macros true]
            [om.dom :as dom :include-macros true]
            [sablono.core :as html :refer-macros [html]]

            [goog.dom :as gdom]

            [weasel.repl :as repl]
            [shodan.console :as console :include-macros true]
            [omdev.core :as omdev]))

(enable-console-print!)

;; connect to weasel repl
(when-not (repl/alive?)
  (repl/connect "ws://localhost:9001" :verbose true))

(def app-state (atom {:text "Hello world!"}))

(om/root
  (fn [app owner]
    (dom/h1 nil (:text app)))
  app-state
  {:target (. js/document (getElementById "app"))})
