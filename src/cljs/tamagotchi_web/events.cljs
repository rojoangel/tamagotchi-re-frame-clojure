(ns tamagotchi-web.events
  (:require [re-frame.core :as re-frame]
            [tamagotchi-web.db :as db]
            [tamagotchi.core :as tamagotchi]))

(re-frame/reg-event-db
 :initialize-db
 (fn  [_ _]
   db/default-db))

(re-frame/reg-event-db
  :tic
  (fn  [db _]
    (tamagotchi/tic db)))

(re-frame/reg-event-db
  :feed
  (fn  [db _]
    (tamagotchi/feed db)))

(re-frame/reg-event-db
  :poo
  (fn  [db _]
    (tamagotchi/make-poop db)))

(re-frame/reg-event-db
  :bed
  (fn  [db _]
    (tamagotchi/put-to-bed db)))

(re-frame/reg-event-db
  :play
  (fn  [db _]
    (tamagotchi/play db)))

(defn dispatch-timer-event []
  (re-frame/dispatch [:tic]))

(defonce do-timer (js/setInterval dispatch-timer-event 1000))