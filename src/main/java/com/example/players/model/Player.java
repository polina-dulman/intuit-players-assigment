package com.example.players.model;


import jakarta.persistence.*;

import java.util.Objects;


@Entity
@Table(name = "players")
public class Player {

	@Id
	@Column(name = "player_id")
	private String playerId;
	@Column(name = "birth_year")
	private Integer birthYear;
	@Column(name = "birth_month")
	private Integer birthMonth;
	@Column(name = "birth_day")
	private Integer birthDay;
	@Column(name = "birth_country")
	private String birthCountry;
	@Column(name = "birth_state")
	private String birthState;
	@Column(name = "birth_city")
	private String birthCity;
	@Column(name = "death_year")
	private Integer deathYear;
	@Column(name = "death_month")
	private Integer deathMonth;
	@Column(name = "death_day")
	private Integer deathDay;
	@Column(name = "death_country")
	private String deathCountry;
	@Column(name = "death_state")
	private String deathState;
	@Column(name = "death_city")
	private String deathCity;
	@Column(name = "name_first")
	private String nameFirst;
	@Column(name = "name_last")
	private String nameLast;
	@Column(name = "name_given")
	private String nameGiven;
	@Column(name = "weight")
	private Integer weight;
	@Column(name = "height")
	private Integer height;
	@Column(name = "bats")
	private String bats;
	@Column(name = "throw_s")
	private String throwS;
	@Column(name = "debut")
	private String debut;
	@Column(name = "final_game")
	private String finalGame;
	@Column(name = "retro_id")
	private String retroId;
	@Column(name = "bbref_id")
	private String bbrefId;

	public Player(String playerId) {
		this.playerId = playerId;
	}

	public Player() {
	}
	public String getPlayerId() {
		return playerId;
	}

	public void setPlayerId(String playerId) {
		this.playerId = playerId;
	}

	public Integer getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(Integer birthYear) {
		this.birthYear = birthYear;
	}

	public Integer getBirthMonth() {
		return birthMonth;
	}

	public void setBirthMonth(Integer birthMonth) {
		this.birthMonth = birthMonth;
	}

	public Integer getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Integer birthDay) {
		this.birthDay = birthDay;
	}

	public String getBirthCountry() {
		return birthCountry;
	}

	public void setBirthCountry(String birthCountry) {
		this.birthCountry = birthCountry;
	}

	public String getBirthState() {
		return birthState;
	}

	public void setBirthState(String birthState) {
		this.birthState = birthState;
	}

	public String getBirthCity() {
		return birthCity;
	}

	public void setBirthCity(String birthCity) {
		this.birthCity = birthCity;
	}

	public Integer getDeathYear() {
		return deathYear;
	}

	public void setDeathYear(Integer deathYear) {
		this.deathYear = deathYear;
	}

	public Integer getDeathMonth() {
		return deathMonth;
	}

	public void setDeathMonth(Integer deathMonth) {
		this.deathMonth = deathMonth;
	}

	public Integer getDeathDay() {
		return deathDay;
	}

	public void setDeathDay(Integer deathDay) {
		this.deathDay = deathDay;
	}

	public String getDeathCountry() {
		return deathCountry;
	}

	public void setDeathCountry(String deathCountry) {
		this.deathCountry = deathCountry;
	}

	public String getDeathState() {
		return deathState;
	}

	public void setDeathState(String deathState) {
		this.deathState = deathState;
	}

	public String getDeathCity() {
		return deathCity;
	}

	public void setDeathCity(String deathCity) {
		this.deathCity = deathCity;
	}

	public String getNameFirst() {
		return nameFirst;
	}

	public void setNameFirst(String nameFirst) {
		this.nameFirst = nameFirst;
	}

	public String getNameLast() {
		return nameLast;
	}

	public void setNameLast(String nameLast) {
		this.nameLast = nameLast;
	}

	public String getNameGiven() {
		return nameGiven;
	}

	public void setNameGiven(String nameGiven) {
		this.nameGiven = nameGiven;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public String getBats() {
		return bats;
	}

	public void setBats(String bats) {
		this.bats = bats;
	}

	public String getThrowS() {
		return throwS;
	}

	public void setThrowS(String throwS) {
		this.throwS = throwS;
	}

	public String getDebut() {
		return debut;
	}

	public void setDebut(String debut) {
		this.debut = debut;
	}

	public String getFinalGame() {
		return finalGame;
	}

	public void setFinalGame(String finalGame) {
		this.finalGame = finalGame;
	}

	public String getRetroId() {
		return retroId;
	}

	public void setRetroId(String retroId) {
		this.retroId = retroId;
	}

	public String getBbrefId() {
		return bbrefId;
	}

	public void setBbrefId(String bbrefId) {
		this.bbrefId = bbrefId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Player player = (Player) o;
		return Objects.equals(playerId, player.playerId) && Objects.equals(birthYear, player.birthYear) && Objects.equals(birthMonth, player.birthMonth) && Objects.equals(birthDay, player.birthDay) && Objects.equals(birthCountry, player.birthCountry) && Objects.equals(birthState, player.birthState) && Objects.equals(birthCity, player.birthCity) && Objects.equals(deathYear, player.deathYear) && Objects.equals(deathMonth, player.deathMonth) && Objects.equals(deathDay, player.deathDay) && Objects.equals(deathCountry, player.deathCountry) && Objects.equals(deathState, player.deathState) && Objects.equals(deathCity, player.deathCity) && Objects.equals(nameFirst, player.nameFirst) && Objects.equals(nameLast, player.nameLast) && Objects.equals(nameGiven, player.nameGiven) && Objects.equals(weight, player.weight) && Objects.equals(height, player.height) && Objects.equals(bats, player.bats) && Objects.equals(throwS, player.throwS) && Objects.equals(debut, player.debut) && Objects.equals(finalGame, player.finalGame) && Objects.equals(retroId, player.retroId) && Objects.equals(bbrefId, player.bbrefId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(playerId, birthYear, birthMonth, birthDay, birthCountry, birthState, birthCity, deathYear, deathMonth, deathDay, deathCountry, deathState, deathCity, nameFirst, nameLast, nameGiven, weight, height, bats, throwS, debut, finalGame, retroId, bbrefId);
	}
}
