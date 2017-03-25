(ns tamagotchi.events
  (:require [re-frame.core :as re-frame]
            [tamagotchi.db :as db]
            [tamagotchi.logic :as logic]))

(re-frame/reg-event-db
 :initialize-db
 (fn  [_ _]
   db/default-db))

(re-frame/reg-event-db
  :tic
  (fn  [db _]
    (logic/tic db)))

(defn dispatch-timer-event []
  (re-frame/dispatch [:tic]))

(defonce do-timer (js/setInterval dispatch-timer-event 1000))