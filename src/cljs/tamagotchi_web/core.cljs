(ns tamagotchi-web.core
    (:require [reagent.core :as reagent]
              [re-frame.core :as re-frame]
              [tamagotchi-web.events]
              [tamagotchi-web.subs]
              [tamagotchi-web.views :as views]
              [tamagotchi-web.config :as config]))


(defn dev-setup []
  (when config/debug?
    (enable-console-print!)
    (println "dev mode")))

(defn mount-root []
  (re-frame/clear-subscription-cache!)
  (reagent/render [views/main-panel]
                  (.getElementById js/document "app")))

(defn ^:export init []
  (re-frame/dispatch-sync [:initialize-db])
  (dev-setup)
  (mount-root))
