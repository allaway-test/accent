(ns accent.chat.agent-ops-test
  (:require [clojure.test :refer :all]
            [accent.chat :refer [->OpenAIProvider ->OpenRouterProvider tool-time get-model switch-model create-agent]]))


(deftest agent-ops-test
  (testing "get-model returns current model"
    (let [provider (->OpenAIProvider "gpt-4o" (atom []) nil tool-time (atom {}))]
      (is (= "gpt-4o" (get-model provider)))))
  
  (testing "switch-model changes the model"
    (let [provider (->OpenAIProvider "gpt-4o" (atom []) nil tool-time (atom {}))]
      (switch-model provider "gpt-3.5-turbo")
      (is (= "gpt-3.5-turbo" (get-model provider))))))

(deftest openrouter-agent-ops-test
  (testing "OpenRouter provider get-model returns current model"
    (let [provider (->OpenRouterProvider "google/gemini-2.5-pro-preview" (atom []) nil tool-time (atom {}))]
      (is (= "google/gemini-2.5-pro-preview" (get-model provider)))))
  
  (testing "OpenRouter provider switch-model changes the model"
    (let [provider (->OpenRouterProvider "google/gemini-2.5-pro-preview" (atom []) nil tool-time (atom {}))]
      (switch-model provider "openai/o3-pro")
      (is (= "openai/o3-pro" (get-model provider))))))

(deftest create-agent-test
  (testing "create-agent with OpenRouter provider"
    (let [agent-config {:provider :openrouter
                        :model "google/gemini-2.5-pro-preview"
                        :role "You are a helpful assistant"
                        :tools []}
          agent (create-agent agent-config)]
      (is (= "google/gemini-2.5-pro-preview" (get-model agent))))))
