package com.example.rixspi.sqllitemanipulation.db;


import android.support.annotation.NonNull;

import com.example.rixspi.sqllitemanipulation.data.model.db.News;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.requery.Persistable;
import io.requery.reactivex.ReactiveEntityStore;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author Jakub Szymion
 * @since 06.06.2016
 */
public class DatabaseWrapper {
    public static final int MIN_SEARCH_LENGTH = 2;
    private final ReactiveEntityStore<Persistable> mData;

    public DatabaseWrapper(@NonNull ReactiveEntityStore<Persistable> data) {
        mData = checkNotNull(data);
    }

    public ReactiveEntityStore<Persistable> getData(){
        return mData;
    }

    public @NonNull Observable<News> getAllNews(){
        return mData.select(News.class).get().observable();
    }

    public @NonNull <T extends Persistable> Single<T> upsert(@NonNull T entity) {
        return mData.upsert(checkNotNull(entity));
    }
//    public @NonNull
//    Observable<UserExerciseEntity> getUserExercises(@NonNull String searchPhrase) {
//        String formattedSearchPhrase = String.format("%%%s%%", checkNotNull(searchPhrase));
//        return mData
//                .select(UserExerciseEntity.class)
//                .where(UserExerciseEntity.NAME.like(formattedSearchPhrase))
//                .or(UserExerciseEntity.DESCRIPTION.like(formattedSearchPhrase))
//                .get()
//                .toObservable();
//    }
//
//    public @NonNull
//    Observable<ExerciseEntity> getAllExercises() {
//        return mData
//                .select(ExerciseEntity.class)
//                .get()
//                .toObservable();
//    }
//
//    public @NonNull
//    Observable<Iterable<ExerciseEntity>> updateExercises(@NonNull List<ExerciseEntity> exerciseEntities) {
//        return mData.delete()
//                .from(ExerciseEntity.class)
//                .get()
//                .toSingle()
//                .toObservable()
//                .flatMap(integer -> mData.upsert(checkNotNull(exerciseEntities)).toObservable());
//    }
//
//    public @NonNull
//    WhereAndOr<Result<ExerciseEntity>> filterOnlyMuscles(@NonNull List<String> musclesIdsToFilter) {
//        WhereAndOr<Result<ExerciseEntity>> query;
//        query = mData
//                .select(ExerciseEntity.class)
//                .where(ExerciseEntity.ID.in(mData.select(ExerciseEntity_MuscleEntity.EXERCISE_ID).where(ExerciseEntity_MuscleEntity.MUSCLE_ID.in(checkNotNull(musclesIdsToFilter)))));
//        return query;
//    }
//
//    public @NonNull
//    WhereAndOr<Result<ExerciseEntity>> filterSelectedEquipmentGroups(
//            @NonNull List<String> equipmentGroups,
//            @NonNull List<String> musclesIdsToFilter) {
//        WhereAndOr<Result<ExerciseEntity>> query;
//        query = mData
//                .select(ExerciseEntity.class)
//                .where(ExerciseEntity.ID.in(mData.select(ExerciseEntity_MuscleEntity.EXERCISE_ID).where(ExerciseEntity_MuscleEntity.MUSCLE_ID.in(checkNotNull(musclesIdsToFilter)))))
//                .and(ExerciseEntity.EQUIPMENT_GROUP.in(checkNotNull(equipmentGroups)));
//        return query;
//    }
//
//    public @NonNull
//    WhereAndOr<Result<ExerciseEntity>> filterExcludedEquipmentGroups(
//            @NonNull List<String> excludedEquipmentGroups,
//            @NonNull List<String> musclesIdsToFilter) {
//        WhereAndOr<Result<ExerciseEntity>> query;
//        query = mData
//                .select(ExerciseEntity.class)
//                .where(ExerciseEntity.ID.in(mData.select(ExerciseEntity_MuscleEntity.EXERCISE_ID).where(ExerciseEntity_MuscleEntity.MUSCLE_ID.in(checkNotNull(musclesIdsToFilter)))))
//                .and(ExerciseEntity.EQUIPMENT_GROUP.notIn(checkNotNull(excludedEquipmentGroups)));
//        return query;
//    }
//
//    public @NonNull
//    WhereAndOr<Result<ExerciseEntity>> filterByExerciseId(@NonNull String id) {
//        return mData.select(ExerciseEntity.class).where(ExerciseEntity.ID.eq(checkNotNull(id)));
//    }
//
//    public @NonNull
//    WhereAndOr<Result<UserExerciseEntity>> filterByUserExerciseId(@NonNull String id) {
//        return mData.select(UserExerciseEntity.class).where(ExerciseEntity.ID.eq(checkNotNull(id)));
//    }
//
//    public @NonNull
//    Observable<ExerciseEntity> filterByExerciseId(@NonNull List<String> ids) {
//        return mData.select(ExerciseEntity.class).where(ExerciseEntity.ID.in(checkNotNull(ids)))
//                .get()
//                .toObservable();
//    }
//
//    public @NonNull
//    Observable<UserExerciseEntity> filterByUserExerciseId(@NonNull List<String> ids) {
//        return mData.select(UserExerciseEntity.class).where(UserExerciseEntity.ID.in(checkNotNull(ids)))
//                .get()
//                .toObservable();
//    }
//
//    public @NonNull
//    Single<Integer> delete(@NonNull String id) {
//        return mData.delete().from(UserExerciseEntity.class).where(UserExerciseEntity.ID.eq(checkNotNull(id))).get().toSingle();
//    }
//
//    public @NonNull
//    Single<Iterable<UserExerciseEntity>> upsert(@NonNull List<UserExerciseEntity> userExercises) {
//        return mData.delete()
//                .from(UserExerciseEntity.class)
//                .get()
//                .toSingle()
//                .flatMap(integer -> mData.upsert(checkNotNull(userExercises)));
//    }
//
//    public @NonNull
//    <T> Observable<T> performQuery(@NonNull WhereAndOr<Result<T>> query) {
//        return query.get().toObservable();
//    }
//
//    public @NonNull
//    Single<UserEntity> getUserProfile() {
//        return mData.select(UserEntity.class).get().toObservable().toSingle();
//    }
//
//    public @NonNull
//    <T extends Persistable> Single<T> update(@NonNull T entity) {
//        return mData.update(checkNotNull(entity));
//    }
//
//    public @NonNull
//    <T extends Persistable> Single<T> upsert(@NonNull T entity) {
//        return mData.upsert(checkNotNull(entity));
//    }
//
//    public @NonNull
//    Single<Integer> clearUserData() {
//        return mData.delete(UserEntity.class).get().toSingle()
//                .flatMap(r -> mData.delete(Activity.class).get().toSingle())
//                .flatMap(r -> mData.delete(ActivityScore.class).get().toSingle())
//                .flatMap(r -> mData.delete(User.class).get().toSingle())
//                .flatMap(r -> mData.delete(UserExercise.class).get().toSingle())
//                .flatMap(r -> mData.delete(Appointment.class).get().toSingle())
//                .flatMap(r -> mData.delete(Coach.class).get().toSingle())
//                .flatMap(r -> mData.delete(Creator.class).get().toSingle())
//                .flatMap(r -> mData.delete(CustomActivityId.class).get().toSingle())
//                .flatMap(r -> mData.delete(InnerExercise.class).get().toSingle())
//                .flatMap(r -> mData.delete(Membership.class).get().toSingle())
//                .flatMap(r -> mData.delete(Organization.class).get().toSingle())
//                .flatMap(r -> mData.delete(Owner.class).get().toSingle())
//                .flatMap(r -> mData.delete(Product.class).get().toSingle())
//                .flatMap(r -> mData.delete(ProductUser.class).get().toSingle())
//                .flatMap(r -> mData.delete(Section.class).get().toSingle())
//                .flatMap(r -> mData.delete(Set.class).get().toSingle())
//                .flatMap(r -> mData.delete(Settings.class).get().toSingle())
//                .flatMap(r -> mData.delete(ShortOrg.class).get().toSingle())
//                .flatMap(r -> mData.delete(Trainer.class).get().toSingle())
//                .flatMap(r -> mData.delete(Workout.class).get().toSingle())
//                .flatMap(r -> mData.delete(WorkoutCreator.class).get().toSingle())
//                .flatMap(r -> mData.delete(WorkoutExercise.class).get().toSingle())
//                .flatMap(r -> mData.delete(WorkoutGroup.class).get().toSingle())
//                .flatMap(r -> mData.delete(AlternativeEquipment.class).get().toSingle());
//    }
//
//    public @NonNull
//    Observable<Appointment> getAppointments() {
//        return mData.select(Appointment.class).get().toObservable();
//    }
//
//    public @NonNull
//    Observable<Activity> getActivities(@NonNull String hash) {
//        return mData.select(Activity.class).where(Activity.SPEC_HASH.eq(checkNotNull(hash))).get().toObservable();
//    }
//
//    public @NonNull
//    Observable<BodyStatistics> getBodyStatistics(@NonNull String hash) {
//        return mData.select(BodyStatistics.class).where(BodyStatistics.SPEC_HASH.eq(checkNotNull(hash))).get().toObservable();
//    }
//
//    public @NonNull
//    Observable<Workout> getWorkouts() {
//        return mData.select(Workout.class).get().toObservable();
//    }
//
//    public @NonNull
//    Observable<Trainer> getTrainer(@NonNull String id) {
//        return mData.select(Trainer.class).where(Trainer.ID.eq(checkNotNull(id))).get().toObservable();
//    }
//
//    public @NonNull
//    Observable<WorkoutGroup> getWorkoutGroups() {
//        return mData.select(WorkoutGroup.class).get().toObservable();
//    }
//
//    public @NonNull
//    Single<Integer> clearWorkoutGroups() {
//        //noinspection ResultOfMethodCallIgnored
//        return mData.delete(WorkoutGroup.class).get().toSingle();
//    }
//
//    public @NonNull
//    Single<Integer> clearInnerExercises() {
//        return mData.delete(InnerExercise.class).get().toSingle();
//    }
//
//    public @NonNull
//    Single<Integer> clearWorkoutExercises() {
//        return mData.delete(WorkoutExercise.class).get().toSingle();
//    }
//
//    public @NonNull
//    Single<Integer> clearWorkouts() {
//        return mData.delete(Workout.class).get().toSingle();
//    }
//
//    public @NonNull
//    Single<Integer> clearScores() {
//        return mData.delete(ActivityScore.class).get().toSingle();
//    }
//
//    public @NonNull
//    Single<Integer> clearCustomActivities() {
//        return mData.delete(CustomActivityId.class).get().toSingle();
//    }
//
//    public @NonNull
//    Single<Integer> clearActivities() {
//        return mData.delete(Activity.class).get().toSingle();
//    }
}
