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
            [omdev.core :as omdev]

            [figwheel.client :as fw]))

(enable-console-print!)

;; connect to weasel repl
(when-not (repl/alive?)
  (repl/connect "ws://localhost:9001" :verbose true))

(defonce app-container (gdom/getElement "app"))
(defonce app-state {:text "Hello world!"})

(defn app-view
  "the root application component"
  [app owner]
  (reify
    om/IRender
    (render [_]
      (html
       [:h1 (:text app)]))))

(defn render
  "Renders the app to the DOM.
  Can safely be called repeatedly to rerender the app."
  []
  (when app-container
    (om/root app-view
             app-state
             {:target app-container})))

(render)

(fw/watch-and-reload
 :jsload-callback (fn []
                    ;; (stop-and-start-my app)
                    ))
